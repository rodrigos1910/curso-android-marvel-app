package com.example.marvelapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.marvelapp.R
import com.example.marvelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment


        navController = navHostFragment.navController

        //seta a navegação nos botoes do menu
        binding.bottomNavMain.setupWithNavController(navController)

        //seta configuração default na barra de menu
        appBarConfiguration = AppBarConfiguration(
            //informa os fragmentos iniciais
            setOf(R.id.charactersFragment, R.id.favoritesFragment, R.id.aboutFragment)
        )

        //preenche a toolbar com o conteudo do menu
        binding.toolbarApp.setupWithNavController(navController, appBarConfiguration)

        //configura o botão de voltar

        navController.addOnDestinationChangedListener { _, destination, _ ->
            //verifica se a tela está nos ids do destinos iniciais
        val isTopLevelDestination = appBarConfiguration.topLevelDestinations.contains(destination.id)
            if (!isTopLevelDestination){
                binding.toolbarApp.setNavigationIcon(R.drawable.ic_back)
            }

        }



    }
}