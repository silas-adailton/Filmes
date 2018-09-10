package com.oliveira.silas.cad.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.oliveira.silas.cad.domain.User
import io.reactivex.Maybe

class RepositoryUser(private var databaseReference: DatabaseReference) : Repository {

    override fun saveUser(): Maybe<User> {
        return Maybe.empty()
    }

    override fun getUsers(): Maybe<List<User>> {

        return Maybe.create {
            databaseReference.child("user").addValueEventListener(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val listUser: MutableList<User> = mutableListOf()

                    for (child: DataSnapshot in dataSnapshot.children) {
                        val user = child.getValue(User::class.java)

                        listUser.add(user!!)
                    }
                    it.onSuccess(listUser)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    it.onError(databaseError.toException())
                }

            })
        }

    }
}