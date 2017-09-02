package app.simone.multiplayer.view.invites

import android.util.Log
import app.simone.multiplayer.model.OnlineMatch
import com.google.firebase.database.DataSnapshot

/**
 * This class is used for downloading matches from the database.
 *
 * @author Giacomo
 * @return requestsUser this is the list of previous/on going matches of a specific user.
 */
class StrategyImpl: Strategy {

    override fun getRequestsUsers(dataSnapshot: DataSnapshot): ArrayList<OnlineMatch> {
        val match = dataSnapshot.children
        Log.d("TESTONLINEMATCH"," value: "+dataSnapshot.getValue().toString())
        val requestsUsers = arrayListOf<OnlineMatch>()
        if (match != null) {
            for (data in match) {
                //val ref = dataSnapshot.child(data.key)
                Log.d("TESTONLINEMATCH", data.getValue().toString())
                val onlineMatch = data.getValue(OnlineMatch::class.java)!!
                onlineMatch.key = data.key
                requestsUsers.add(onlineMatch)
            }
        }
        return requestsUsers
    }
}