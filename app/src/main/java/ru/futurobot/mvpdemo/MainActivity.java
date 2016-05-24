package ru.futurobot.mvpdemo;

import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.Observable;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.futurobot.mvpdemo.models.Person;
import ru.futurobot.mvpdemo.views.PersonsView;

public class MainActivity extends AppCompatActivity implements PersonsView {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.messageTextView)
    TextView mMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new PersonsAdapter());
    }

    @Override
    public void showLoading() {
        mRecyclerView.setVisibility(View.INVISIBLE);
        mMessageTextView.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        mRecyclerView.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.INVISIBLE);
        mMessageTextView.setVisibility(View.VISIBLE);
        mMessageTextView.setText(message);
    }

    @Override
    public void publishPersons(List<Person> persons) {
        mProgressBar.setVisibility(View.INVISIBLE);
        mMessageTextView.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    /**
     * Persons adapter
     */
    public class PersonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private SparseArrayCompat<Person> mPersons = new SparseArrayCompat<>();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mPersons.size();
        }

        /**
         * Item view holder
         */
        private class ViewHolder extends RecyclerView.ViewHolder{

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
