package android.course.dialogs;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderSummaryFragment extends Fragment {
    private TextView tvToppings, tvTime, tvSize;
    private OnTextChangedListener mListener;



    public OrderSummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order_summary, container, false);
        tvToppings = (TextView) v.findViewById(R.id.tvToppings);
        tvTime = (TextView) v.findViewById(R.id.tvTime);
        tvSize = (TextView) v.findViewById(R.id.tvSize);

        return v;
    }

    public interface OnTextChangedListener {
        void onTextChanged(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTextChangedListener) {
            mListener = (OnTextChangedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTextChangedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void onTextChanged(String text) {
        if (mListener != null) {
            mListener.onTextChanged(text);
        }
    }

}
