package com.ray.mitiendita.Modelos;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.structure.BaseQueryModel;

@QueryModel(database = AppDB.class)
public class TotalDeuda extends BaseQueryModel {
    @Column
    public float totalDeuda;
}
