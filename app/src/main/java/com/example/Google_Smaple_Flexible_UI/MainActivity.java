/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.Google_Smaple_Flexible_UI;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.training.R;

public class MainActivity extends FragmentActivity
        implements HeadlinesFragment.OnHeadlineSelectedListener {
    static String Tag = "MainActivity";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.fragment_container) != null) {
            Log.i(Tag, "onCreate: "+"findViewById(R.id.fragment_container) != null");
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return zor else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                Log.i(Tag, "onCreate: "+"savedInstanceState != null");
                return;
            }

            // Create an instance of ExampleFragment
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

//    //設定螢幕旋轉不執行任何動作
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        Log.i(Tag, "onConfigurationChanged()");
//        // TODO Auto-generated method stub
//        super.onConfigurationChanged(newConfig);
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            // 什麼都不用寫
//            Log.i(Tag, "onConfigurationChanged()1");
//            setContentView(R.layout.news_articles_1);
//        }
//        else {
//            // 什麼都不用寫
//            Log.i(Tag, "onConfigurationChanged()2");
//            setContentView(R.layout.news_articles);
//        }
//    }

    public void onArticleSelected(int position) {
        Log.i(Tag, "onArticleSelected: "+"position:"+position);
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout

        ArticleFragment articleFrag = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.headlines_fragment);

        Log.i(Tag, "onArticleSelected: "+"articleFrag:"+articleFrag);
        if (articleFrag != null) {
            Log.i(Tag, "onArticleSelected: "+"articleFrag != null111111111111111111111111111");
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);

        } else {
            Log.i(Tag, "onArticleSelected: "+"articleFrag != null else22222222222222222222222222222");
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        //保存选择RadioButton的Id
//        outState.putInt(LAST_CHOICE, mRadioGroup.getCheckedRadioButtonId());
    }
}