//package com.example.flowers_k;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
//class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {
//    private final static String PHOTO_URL = "https://services.hanselandpetal.com/photos/";
//    private List<Pet> mPets;
//    private Context mContext;
//
//    PetAdapter(List<Pet> pets) {
//
//        this.mPets = pets;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        mContext = parent.getContext();
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        Pet flower = mPets.get(position);
//        holder.nameTextView.setText(flower.getName());
//
////        Picasso.with(mContext)
////                .load(PHOTO_URL + flower.getPhoto())
////                .into(holder.flowerImageView);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mPets == null) {
//            return 0;
//        }
//        return mPets.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        TextView nameTextView;
//        ImageView flowerImageView;
//
//        ViewHolder(View itemView) {
//            super(itemView);
//            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
//            flowerImageView = (ImageView) itemView.findViewById(R.id.itemImageView);
//        }
//    }
//}