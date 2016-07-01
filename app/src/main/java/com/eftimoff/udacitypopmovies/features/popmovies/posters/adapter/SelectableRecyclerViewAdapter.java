package com.eftimoff.udacitypopmovies.features.popmovies.posters.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;

import java.util.ArrayList;
import java.util.List;

public abstract class SelectableRecyclerViewAdapter<H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {

    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    @Override
    public void onBindViewHolder(H viewHolder, int position) {
        viewHolder.itemView.setActivated(selectedItems.get(position, false));
    }

    public void toggleSelection(int pos) {
        if (selectedItems.get(pos, false)) {
            selectedItems.delete(pos);
        } else {
            selectedItems.put(pos, true);
        }
        notifyItemChanged(pos);

    }

    public void setSelected(int pos) {
        selectedItems.put(pos, true);
        notifyItemChanged(pos);

    }

    public void clearSelection(int pos) {
        if (selectedItems.get(pos, false)) {
            selectedItems.delete(pos);
        }
        notifyItemChanged(pos);
    }

    public void clearSelections() {
        if (selectedItems.size() > 0) {
            selectedItems.clear();
            notifyDataSetChanged();
        }
    }


    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    public List<Integer> getSelectedItemsPositions() {
        List<Integer> items = new ArrayList<Integer>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }

}