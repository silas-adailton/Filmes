package com.oliveira.silas.cad.data

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.oliveira.silas.cad.domain.User
import io.reactivex.Maybe

class RepositoryUser(private var databaseReference: DatabaseReference) : Repository {

    override fun giveHello() = "Hello Koin"

    override fun saveUser(): Maybe<User> {
        return Maybe.empty()
    }

    override fun getUsers(): Maybe<List<User>> {

        return Maybe.create {
            databaseReference.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                     val listUser: MutableList<User> = mutableListOf()
//                    listUser = mutableListOf()
                    for (child: DataSnapshot in dataSnapshot.children) {
                        val user = child.getValue(User::class.java)

                        listUser.add(user!!)
                        Log.i("TESTE:", listUser.get(0).name)
                    }
                    it.onSuccess(listUser)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    it.onError(databaseError.toException())
                    Log.d("TESTE","Error: "+databaseError)
                }

            })
        }

//        databaseReference.child("user").addValueEventListener(object : ValueEventListener {
//
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                Log.d("TESTE","Snap: "+dataSnapshot.toString())
//
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                Log.d("TESTE","Error: "+databaseError)
//            }
//
//        })
//
//        return Maybe.empty()
    }
}