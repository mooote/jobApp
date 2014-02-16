package com.example.gitjob.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gitjob.R;


public class Fragment1 extends Fragment {
	int pageNumber;
	public static View view;
	static Fragment1 newInstance(int pageNumber){
		//fragment initial set 
		Fragment1 searchFragment = new Fragment1();
		Bundle bundle= new Bundle();
		bundle.putInt("nn", pageNumber);
		searchFragment.setArguments(bundle);
		return searchFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
		    ViewGroup container, Bundle savedInstanceState) {
		    view =  inflater.inflate(R.layout.result_page, null);		
			return view;
		  }
}