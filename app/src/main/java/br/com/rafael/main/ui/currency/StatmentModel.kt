package br.com.rafael.main.ui.currency

import br.com.rafael.main.model.ErrorService
import br.com.rafael.main.model.Statement
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class StatmentModel {

    class StatmentViewModel(val title:String,val des:String?, val date:String?, val value:Float):Serializable

    class StatmentResponse(@SerializedName(value = "statementList")val listStatment:List<Statement>,
                           @SerializedName(value = "error")val error:ErrorService) {

        fun toModelView(): List<StatmentViewModel> {
            val mutableListOf = mutableListOf<StatmentModel.StatmentViewModel>()

            for (statement in listStatment){
                mutableListOf.add(StatmentViewModel(statement.title,statement.desc,statement.date,statement.value))

            }

            return mutableListOf
        }
    }

    class StatmentRequest()


}