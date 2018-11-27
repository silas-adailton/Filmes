package com.oliveira.silas.data.remote.user

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.oliveira.silas.domain.user.Repository
import com.oliveira.silas.domain.user.User
import io.reactivex.Maybe

@Suppress("UNREACHABLE_CODE")
class RepositoryUser(private var databaseReference: DatabaseReference) : Repository {
    private  val listUser: MutableList<User> = mutableListOf()
    private var throwable: Throwable? = null
    override fun getUserCourotine(): MutableList<User> {
         databaseReference.child("user").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                throwable = databaseError.toException()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val listUser: MutableList<User> = mutableListOf()
                for (child: DataSnapshot in dataSnapshot.children) {
                    val user = child.getValue(User::class.java)

                    listUser.add(user!!)
                }
            }

        })

        if (throwable == null) {
            return listUser
        }

        return error(throwable!!)
    }

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