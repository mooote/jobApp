package com.example.gitjob.fragment;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gitjob.JobInfoItems;
import com.example.gitjob.JobListAdapter;
import com.example.gitjob.MainActivity;
import com.example.gitjob.R;


public class Fragment0 extends Fragment {
	ListView quickList;
	EditText searchBar;
	ImageButton searchButton;
	ListView  resultList;
	TextView description;
	TextView pleaseInput;
	//TextView pleaseInputReturn;
	private ShowBoxTask task; // add task to show progress box display
	public ArrayAdapter<JobInfoItems> adapter; // arrayList and adapter
	public static View view;
    	
	public OnFocusChangeListener keywordInputOnFocusChangeListener;
	
	// set up search button click
    public OnClickListener searchBtnOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
        	MainActivity.lastResultList.clear();
        	if(MainActivity.lastResultList.size()<=0){
                MainActivity.lastResultList.clear();
                TextView pleaseInput = (TextView)view.findViewById(R.id.tv_pleaseInput);
        	      pleaseInput.setText(""); 
        	}
        	
        	//pleaseInput.setText("");
        	
            // clear list result

        	// clear error messages
        	//if(pleaseInput.getText().toString()!=null){
    	  		//pleaseInput.setText("");
        	//}
    		//final TextView noResult  = (TextView)Fragment0.view.findViewById(R.id.tv_noResult);
    	    //noResult.setText("");
        	//} 
        	// edit text error message text set
            EditText searchBar= (EditText) getActivity().findViewById(R.id.et_keyword);       	
            MainActivity.ENCODE_jPlace_initial= searchBar.getText().toString();
			if(MainActivity.ENCODE_jPlace_initial.length()==0){ 
				TextView pleaseInput = (TextView)view.findViewById(R.id.tv_pleaseInput);
				pleaseInput.setText("oops! correct typing please");
				pleaseInput.setTextSize(25); 
				return;
    	    	}
          	// set adaptor and layout page and list
            adapter = new JobListAdapter(getActivity(), R.layout.search_page, MainActivity.lastResultList);
        	// search result list set to adaptor 
            quickList.setAdapter(adapter);
        	// set task into the first page 
    		task =new ShowBoxTask();
    		// AsyncTask execute 
    		task.execute();
        }
    };
   
    
	// create a new class connecting AsyncTask
	class ShowBoxTask extends AsyncTask<Object, Integer, String> {
		// create dialog
		private ProgressDialog dialog;

		//onPreExecute
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// progress window set up
			dialog = new ProgressDialog(getActivity()); 
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			dialog.setMessage("loading...");
			// to make sure the page stays when other area is clicked
			dialog.setCanceledOnTouchOutside(false);
			// boolean 										
			dialog.setCancelable(false);
			dialog.show();
		}
		
		
		
		// doInBackground
		@Override
		protected String doInBackground(Object... params) {
			MainActivity.parseJson();
			return null;// fetching info from json
		}

		// showing background action progress in number
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			dialog.setProgress(values[0]);// start with 0!
		}

		// showing when background action is completed
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);// show parameter result
			adapter.notifyDataSetChanged();
			dialog.dismiss();

		}
	} 

  @Override
  public View onCreateView(LayoutInflater inflater,
    ViewGroup container, Bundle savedInstanceState) {
	//List
	view =  inflater.inflate(R.layout.search_page, null);
	quickList = (ListView) view.findViewById(R.id.list1);
	quickList.setOnItemClickListener(new OnItemClickListener() {
        //swipe function
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			      MainActivity.pageControl=true;
			        MainActivity.pageLock.notifyDataSetChanged();
					((MainActivity)getActivity()).viewPager.setCurrentItem(1);
					MainActivity.listNumber = arg2;
					//JobInfoItems item = MainActivity.lastResultList.get(MainActivity.listNumber);
					if(MainActivity.lastResultList.size()>0){
					    JobInfoItems item = MainActivity.lastResultList.get(MainActivity.listNumber);
					    
					    TextView description = (TextView) Fragment1.view.findViewById(R.id.tv_description);
					    String de = item.getDescription();
					    description.setText(Html.fromHtml(de));
					    description.setTextSize(10);
					    TextView howToApply = (TextView)Fragment1.view.findViewById(R.id.tv_howToApply);
					    String ho = item.getDescription();
					    description.setText(Html.fromHtml(ho));
					    howToApply.setTextSize(10);
					    TextView companyUrl = (TextView)Fragment1.view.findViewById(R.id.tv_companyUrl);
					    String co = item.getDescription();
					    description.setText(Html.fromHtml(co));
					    companyUrl.setTextSize(10);
					    Linkify.addLinks(companyUrl, Linkify.WEB_URLS);
					    }
									
		}
	});
	
	//search bar layout set
	searchBar= (EditText) view.findViewById(R.id.et_keyword);
	//search button layout set
	searchButton= (ImageButton) view.findViewById(R.id.ibtn_search);
	// set search button on listener
	searchButton.setOnClickListener(searchBtnOnClickListener);
	return view;
  }

}

/** code for url open
method throws Exception {

        URL oracle = new URL("http://www.oracle.com/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
    */
