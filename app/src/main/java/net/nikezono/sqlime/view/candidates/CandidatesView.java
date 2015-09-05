/*
 * Copyright (C) 2008-2009 The Android Open Source Project
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

package net.nikezono.sqlime.view.candidates;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;

import com.linearlistview.LinearListView;

import net.nikezono.sqlime.SQLime;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.ViewById;

import hugo.weaving.DebugLog;

@EView
public class CandidatesView extends HorizontalScrollView {

    @ViewById
    LinearListView candidatesList;

    public CandidatesView(Context context,AttributeSet set){
        super(context,set);
    }
    public void setAdapter(ArrayAdapter<?> adapter) {
        candidatesList.setAdapter(adapter);
    }

    @DebugLog
    @AfterViews
    void setItemClickListener(){
        candidatesList.setOnItemClickListener(new LinearListView.OnItemClickListener() {
            @Override
            public void onItemClick(LinearListView linearListView, View view, int i, long l) {
                SQLime.getService().onClickCandidate(i);
            }
        });
    }
}
