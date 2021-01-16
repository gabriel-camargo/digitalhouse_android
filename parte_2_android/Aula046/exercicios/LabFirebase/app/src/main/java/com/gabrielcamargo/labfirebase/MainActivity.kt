package com.gabrielcamargo.labfirebase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import java.lang.System.currentTimeMillis


class MainActivity : AppCompatActivity() {

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        obterArquivo()

        findViewById<Button>(R.id.btnProcurar).setOnClickListener {
            procurarArquivo()
        }

        findViewById<Button>(R.id.btnEnviar).setOnClickListener {
            enviarArquivo()
        }
    }

    fun obterArquivo() {
        val firebase = FirebaseStorage.getInstance()
        val storage = firebase.getReference("uploads")

        storage.child("1610759749732.jpg").downloadUrl.addOnSuccessListener {
            Picasso.get().load(it).into(findViewById<ImageView>(R.id.imageView))
        }
    }

    fun enviarArquivo() {
        imageUri?.run {
            val firebase = FirebaseStorage.getInstance()
            val storage = firebase.getReference("uploads")

            val extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(contentResolver.getType(this))
            val fileReference = storage.child("${currentTimeMillis()}.${extension}")

            fileReference.putFile(this)
                .addOnSuccessListener {
                    Toast.makeText(this@MainActivity, "Sucesso rapaz!", Toast.LENGTH_SHORT).show()
                    Log.d("GS_NAME", fileReference.toString())
                }
                .addOnFailureListener {
                    Toast.makeText(this@MainActivity, "Deu ruim rapaz!", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener {
//                    Log.d("PROGRESS", it.bytesTransferred)
                }
        }
    }

    fun procurarArquivo() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, CONTENT_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == CONTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            imageUri = data?.data
            findViewById<ImageView>(R.id.imageView).setImageURI(imageUri)
        }
    }

    companion object {
        const val CONTENT_REQUEST_CODE = 1
    }
}