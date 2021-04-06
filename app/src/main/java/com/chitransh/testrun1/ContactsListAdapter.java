package com.chitransh.testrun1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ContactsListAdapter extends BaseAdapter {

  private final Context context;
  private List<Contact> contactList;

  public ContactsListAdapter(Context context) {
    this.context = context;
  }

  @Override
  public int getCount() {
    return contactList.size();
  }

  @Override
  public Contact getItem(int position) {
    return contactList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = LayoutInflater.from(context).inflate(R.layout.list_item_contact, null);

    TextView tvName = view.findViewById(R.id.tvName);
    TextView tvNumber = view.findViewById(R.id.tvNumber);
    Button bCall = view.findViewById(R.id.bCall);

    Contact contact = getItem(position);

    tvName.setText(contact.getName());
    tvNumber.setText(contact.getNumber());

    bCall.setOnClickListener(v -> {
      Intent intent = new Intent(Intent.ACTION_DIAL);
      intent.setData(Uri.parse("tel:" + contact.getNumber()));
      context.startActivity(intent);
    });

    return view;
  }

  public void setContactList(List<Contact> contactList) {
    this.contactList = contactList;
    notifyDataSetChanged();
  }
}
