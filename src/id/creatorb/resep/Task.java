package id.creatorb.resep;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

public class Task extends AsyncTask<String, Integer, Integer> {

	public interface TaskFinishedListener {
		void onTaskFinished(); // If you want to pass something back to the listener add a param to this method
	}

	// This is the progress bar you want to update while the task is in progress
	private final ProgressBar progressBar;
	// This is the listener that will be told when this task is finished
	private final TaskFinishedListener finishedListener;

	/**
	 * A Loading task that will load some resources that are necessary for the app to start
	 * @param progressBar - the progress bar you want to update while the task is in progress
	 * @param finishedListener - the listener that will be told when this task is finished
	 */
	public Task(ProgressBar progressBar, TaskFinishedListener finishedListener) {
		this.progressBar = progressBar;
		this.finishedListener = finishedListener;
	}

	@Override
	protected Integer doInBackground(String... params) {
		Log.i("Tutorial", "Starting task with url: "+params[0]);
		if(resourcesDontAlreadyExist()){
			downloadResources();
		}
		// Perhaps you want to return something to your post execute
		return 1234;
	}

	private boolean resourcesDontAlreadyExist() {
		// Here you would query your app's internal state to see if this download had been performed before
		// Perhaps once checked save this in a shared preference for speed of access next time
		return true; // returning true so we show the splash every time
	}


	private void downloadResources() {
		// We are just imitating some process thats takes a bit of time (loading of resources / downloading)
		int count = 10;
		for (int i = 0; i < count; i++) {

			// Update the progress bar after every step
			int progress = (int) ((i / (float) count) * 100);
			publishProgress(progress);

			// Do some long loading things
			try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
		}
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		progressBar.setProgress(values[0]); // This is ran on the UI thread so it is ok to update our progress bar ( a UI view ) here
	}

	@Override
	protected void onPostExecute(Integer result) {
		super.onPostExecute(result);
		finishedListener.onTaskFinished(); // Tell whoever was listening we have finished
	}
}