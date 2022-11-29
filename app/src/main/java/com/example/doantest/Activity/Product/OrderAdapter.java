package com.example.doantest.Activity.Product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doantest.R;

import java.util.List;

public class OrderAdapter extends  RecyclerView.Adapter<OrderAdapter.ProductViewHolder>{

    private List<Order> mListProduct;
    private IClickDelete iClickDelete;
    public interface IClickDelete{
        void OnClickDelete(ImageView imgDelete, Order product);
    }

    public void setData(List<Order> list, IClickDelete clickDelete){
        this.mListProduct = list;
        this.iClickDelete = clickDelete;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vieworder, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Order product = mListProduct.get(position);
        if (product == null){
            return;
        }
        holder.imgProduct.setImageResource(product.getResourceId());
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickDelete.OnClickDelete(holder.imgDelete, product);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListProduct != null){
            return mListProduct.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgProduct, imgDelete;
        private TextView tvProductName, tvProductPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.img_product);
            imgDelete = itemView.findViewById(R.id.img_delete);
            tvProductName = itemView.findViewById(R.id.tv_title_product);
            tvProductPrice = itemView.findViewById(R.id.tv_price_product);
        }
    }
}
