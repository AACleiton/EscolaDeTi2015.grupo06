(function(){
	'use strict';
	
    moduleApp
    .config(["$routeProvider", function($routeProvider) {
        return $routeProvider

        // HOME
        .when("/", {
            redirectTo: "/dashboard"
        })
        .when("/dashboard", {
            templateUrl: "views/dashboard.html"
        })

        // USUÁRIO
        .when("/usuario/cadastrar", {
            templateUrl: "views/escola-de-ti/usuario/cadastrar.html",
            controller: "UsuarioCadastrar"
        })
        .when("/usuario/listar", {
            templateUrl: "views/escola-de-ti/usuario/listar.html",
            controller: "UsuarioListar"
        })
        .when("/usuario/editar/:id", {
            templateUrl: "views/escola-de-ti/usuario/cadastrar.html",
            controller: "UsuarioEditar"
        })


        .when("/404", {
            templateUrl: "views/pages/404.html"
        }).otherwise({
            redirectTo: "/404"
        })
    }])

}())