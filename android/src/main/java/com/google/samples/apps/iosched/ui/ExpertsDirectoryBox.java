package com.google.samples.apps.iosched.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.samples.apps.iosched.R;
import com.google.samples.apps.iosched.ui.widget.CollectionView;
import com.google.samples.apps.iosched.ui.widget.CollectionViewCallbacks;
import com.google.samples.apps.iosched.ui.widget.MessageCardView;
import com.jimulabs.mirrorsandbox.MirrorAnimatorSandbox;

/**
 * Created by lintonye on 14-12-31.
 */
public class ExpertsDirectoryBox extends MirrorAnimatorSandbox {
    public ExpertsDirectoryBox(View root) {
        super(root);
    }

    @Override
    public void enterSandbox() {
        CollectionView collectionView = (CollectionView) $(R.id.collection_view).getView();
        CollectionView.Inventory inv = new CollectionView.Inventory();
        CollectionView.InventoryGroup invGroup = new CollectionView.InventoryGroup(1);
        invGroup.addItemWithTag("abc");
        invGroup.addItemWithTag("abc");
        invGroup.setHeaderLabel("Header");
        inv.addGroup(invGroup);
        collectionView.setCollectionAdapter(new CollectionViewCallbacks() {
            @Override
            public View newCollectionHeaderView(Context context, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.header_experts_directory, parent, false);
            }

            @Override
            public void bindCollectionHeaderView(Context context, View view, int groupId, String headerLabel) {
                MessageCardView card = (MessageCardView) view.findViewById(R.id.message_card);
                card.setTitle(headerLabel);
            }

            @Override
            public View newCollectionItemView(Context context, int groupId, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.list_item_expert, parent, false);
            }

            @Override
            public void bindCollectionItemView(Context context, View view, int groupId, int indexInGroup, int dataIndex, Object tag) {
                ((TextView)view.findViewById(R.id.name)).setText("Larry Page");
                ((TextView)view.findViewById(R.id.summary)).setText("Some summary");
                ((TextView)view.findViewById(R.id.bio)).setText("Some bio: work on things that don't exist yet");
            }
        });

        collectionView.updateInventory(inv, true);
    }
}
