package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.anggora,
            R.drawable.domestik,
            R.drawable.mainecoon,
            R.drawable.munchkin,
            R.drawable.persia,
            R.drawable.ragdoll,
            R.drawable.russianblue,
            R.drawable.scottishfold,
            R.drawable.siam,
            R.drawable.sphynx,
        )

        title = arrayOf(
            getString(R.string.Anggora),
            getString(R.string.Domestik),
            getString(R.string.maininecoon),
            getString(R.string.munchkin),
            getString(R.string.persia),
            getString(R.string.ragdoll),
            getString(R.string.russianblue),
            getString(R.string.scottishflod),
            getString(R.string.siam),
            getString(R.string.sphynx),

        )
        description = arrayOf(
            getString(R.string.desc_anggora),
            getString(R.string.desc_domestik),
            getString(R.string.desc_maininecoon),
            getString(R.string.desc_munchkin),
            getString(R.string.desc_persia),
            getString(R.string.desc_ragdoll),
            getString(R.string.desc_russianblue),
            getString(R.string.desc_scottishflod),
            getString(R.string.desc_siam),
            getString(R.string.desc_sphynx),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
