package com.thebaileybrew.angry_nerds_demo_recycler;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AngryNerdAdapter extends RecyclerView.Adapter<AngryNerdAdapter.NerdHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<AngryNerd> NerdsDatabase;

    //Creates the actual method of performing the recycler
    public AngryNerdAdapter(Context context, ArrayList<AngryNerd> NerdsDatabase) {
        this.layoutInflater = LayoutInflater.from(context);
        this.NerdsDatabase = NerdsDatabase;
    }

    //Creates the view that is inflated via the Recycler
    @Override
    public NerdHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.nerd_item_view, parent, false);
        return new NerdHolder(view);
    }

    //Binds your Array data to the particular layout views
    @Override
    public void onBindViewHolder(NerdHolder holder, int position) {
        final AngryNerd currentNerd = NerdsDatabase.get(position);

        //Assign the values of your ArrayList to the assigned holder views
        holder.nerdName.setText(currentNerd.getNerdName());
        holder.nerdProject.setText(currentNerd.getNerdProject());
        holder.nerdId.setText(String.valueOf(currentNerd.getNerdId()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You've selected: " + currentNerd.getNerdName(), Toast.LENGTH_SHORT).show();
                //This is where you can define how your item should respond when clicked.
                //Intent, Toasts, etc, etc, etc...
            }
        });

    }

    //Returns your Array size
    @Override
    public int getItemCount() {
        return NerdsDatabase.size();
    }

    //This is a custom holder which is how your data binding occurs, this is where the ids are assigned.
    class NerdHolder extends RecyclerView.ViewHolder {
        private TextView nerdName;
        private TextView nerdProject;
        private TextView nerdId;

        private NerdHolder(View nerdView) {
            super(nerdView);
            nerdName = nerdView.findViewById(R.id.nerd_name);
            nerdProject = nerdView.findViewById(R.id.nerd_project);
            nerdId = nerdView.findViewById(R.id.nerd_id);


        }
    }
}
