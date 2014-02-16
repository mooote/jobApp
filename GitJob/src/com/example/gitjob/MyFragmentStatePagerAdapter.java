package com.example.gitjob;

import com.example.gitjob.fragment.Fragment0;
import com.example.gitjob.fragment.Fragment1;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyFragmentStatePagerAdapter
  extends FragmentStatePagerAdapter {

  public MyFragmentStatePagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int i) {
	  //setting up each pages default page1 appears first
    switch(i){
    case 0:
      return new Fragment0();
    case 1:
      return new Fragment1();
      default: return null;
    }

  }

  @Override
  public int getCount() {
    return 2;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return "Page " + position;
  }

}