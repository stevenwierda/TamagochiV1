package com.example.tamagochiv1.services

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.AsyncTask
import android.os.Build
import android.os.SystemClock
import android.util.Log
import androidx.annotation.RequiresApi



@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class JobService : JobService() {


    private val TAG = "JobService"



    override fun onStartJob(params: JobParameters?): Boolean {
        TODO("Not yet implemented")

        var miniAsyncTask = MiniAsyncTask()
        miniAsyncTask.execute()

    }

    override fun onStopJob(params: JobParameters?): Boolean {
        TODO("Not yet implemented")
    }



     class MiniAsyncTask : AsyncTask<Int, Int, String>() {

        private val TAG = "JobService"

        override fun doInBackground(vararg params: Int?): String? {
            for(i in 1..10) {
                SystemClock.sleep(1000)
                publishProgress(i)
            }

            return "Job Finished"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

            Log.d(TAG, "onProgressUpdate: i was: "+values[0])

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            Log.d(TAG, "onPostExecute: message: " + result)
        }

    }

}
