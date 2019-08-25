package com.imastudio.remmss.fashinoapp.detailProdukkategori.model

import com.imastudio.remmss.fashinoapp.home.produk.modelProduk.DataItem
import java.io.Serializable

data class ResultProdukPerKategori(

    var pesan : String? = null,var sukses : Boolean? = null,var data : List<DataItem>
) {



}