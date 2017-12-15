package com.mireagaloideal.apportame.main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mireagaloideal.apportame.GenericFragment;
import com.mireagaloideal.apportame.R;
import com.mireagaloideal.apportame.data.RegaloFromWS;
import com.mireagaloideal.apportame.data.RegaloToWS;
import com.mireagaloideal.apportame.interfaces.DialogDoubleActions;
import com.mireagaloideal.apportame.interfaces.OnItemClickListener;
import com.mireagaloideal.apportame.main.adapters.RecyclerSearchGiftsAdapter;
import com.mireagaloideal.apportame.main.presenters.SearchGiftPresenter;
import com.mireagaloideal.apportame.main.presenters.interfaces.ISearchGiftPresenter;
import com.mireagaloideal.apportame.main.view.SearchGiftViewManager;
import com.mireagaloideal.apportame.net.APIClient;
import com.mireagaloideal.apportame.net.IApiClient;
import com.mireagaloideal.apportame.utils.Preferencias;
import com.mireagaloideal.apportame.utils.RegaloProgressLayout;
import com.mireagaloideal.apportame.utils.UI;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public class SearchGiftFragment extends GenericFragment implements View.OnClickListener, SearchGiftViewManager, OnItemClickListener {

    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;


    private ISearchGiftPresenter presenter;
    private RecyclerSearchGiftsAdapter recyclerAdapter;

    public static SearchGiftFragment newInstance() {
        SearchGiftFragment fragment = new SearchGiftFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SearchGiftPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_search_gift, container, false);
        initViews();
        return rootview;
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this, rootview);
        btnSearch.setOnClickListener(this);

        recyclerview.setHasFixedSize(true);
        //recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onClick(View view) {
        //Buscar
        UI.hideKeyBoard(getActivity());
        RegaloProgressLayout.show(getContext());
        presenter.searchGifts(search.getText().toString());
    }

    @Override
    public void printGifts(List<RegaloFromWS> regalos) {
        RegaloProgressLayout.hide();
        if (regalos.size() > 0) {
            recyclerAdapter = new RecyclerSearchGiftsAdapter(regalos, this);
            recyclerview.setAdapter(recyclerAdapter);
        }

    }

    @Override
    public void showError(Object error) {
        RegaloProgressLayout.hide();
    }

    @Override
    public void onItemClick(Object... objects) {
        final RegaloFromWS regalo = (RegaloFromWS) objects[0];
        String message = "¿Quieres elegir: " + regalo.getName() + " como tu regalo ideal?";
        UI.createSimpleCustomDialog("Tu Regalo Ideal", message, getFragmentManager(), new DialogDoubleActions() {
            @Override
            public void actionConfirm(Object... params) {
                Toast.makeText(getContext(), "Regalo Agregado", Toast.LENGTH_SHORT).show();
                RegaloToWS regaloToWS = new RegaloToWS();
                regaloToWS.setName(regalo.getName());
                regaloToWS.setPrice(regalo.getPrice());
                regaloToWS.setUrl_image(regalo.getUrl_image());

                APIClient.getClient().create(IApiClient.class).saveItem(regaloToWS).enqueue(new Callback<RegaloToWS>() {
                    @Override
                    public void onResponse(Call<RegaloToWS> call, Response<RegaloToWS> response) {
                        Toast.makeText(getContext(), "Save Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RegaloToWS> call, Throwable t) {
                        Toast.makeText(getContext(), "Save Error", Toast.LENGTH_SHORT).show();
                    }
                });

                Preferencias.getInstance(getContext()).saveRegalo(regalo);
            }

            @Override
            public void actionCancel(Object... params) {

            }
        }, true, true);
    }

}
