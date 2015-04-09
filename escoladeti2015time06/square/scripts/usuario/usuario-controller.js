(function() {
	"use strict";
	
	angular.module("app.UsuarioController", [])
	.controller("UsuarioCadastrar", function($scope, $location) {
	 
		
		$scope.submitForm = function(){
			alert('kb')
		}
		var original;
        return $scope.usuario = {
            nome: "",
            email: "",
            login: "",
            senha: "",
            ativo: "",

        }, original = angular.copy($scope.usuario), $scope.revert = function() {
            return $scope.usuario = angular.copy(original), $scope.usuario.$setPristine()
        }, $scope.canRevert = function() {
            return !angular.equals($scope.usuario, original) || !$scope.usuario.$pristine
        }, $scope.canSubmit = function() {
            return $scope.usuario.$valid && !angular.equals($scope.usuario, original)
        }


	})


	.controller("UsuarioEditar", function($scope, $routeParams) {
	 
		alert( $routeParams.id )

	})

	
	.controller("UsuarioListar", ["$scope", "$filter", function($scope, $filter) {
	 
		var init;
        $scope.stores = [
        	{
				"id" : 1,
				"nome" : "Nome Exemplo",
				"email": "email@exemplo.com",
				"perfil" : [
					{"nome": "Pefil 1", "status": "C"},
					{"nome": "Pefil 3", "status": "C"},
					{"nome": "Pefil 7", "status": "M"}
				],
				"status": "ATIVO"
			},
			{
				"id": 2,
				"nome": "Nome Exemplo 2",
				"email": "email2@exemplo.com",
				"perfil": [],
				"status": "ATIVO"
			},
			{
				"id": 3,
				"nome": "Nome Exemplo 3",
				"email": "email3@exemplo.com",
				"perfil": [
					{ "nome": "Pefil 1", "status": "C"},
				],
				"status": "INATIVO"
			},
			{
				"id": 4,
				"nome": "Nome Exemplo 4",
				"email": "email4@exemplo.com",
				"perfil": [
					{ "nome": "Pefil 1", "status": "C"},
					{"nome": "Pefil 10", "status": "C"},
				],
				"status": "ATIVO"
			},
			{
				"id": 5,
				"nome": "Nome Exemplo 5",
				"email": "email4@exemplo.com",
				"perfil": [
					{ "nome": "Pefil 1", "status": "C"},
					{"nome": "Pefil 10", "status": "C"},
				],
				"status": "ATIVO"
			},
			{
				"id": 6,
				"nome": "Nome Exemplo 6",
				"email": "email4@exemplo.com",
				"perfil": [
					{ "nome": "Pefil 1", "status": "C"},
					{"nome": "Pefil 10", "status": "C"},
				],
				"status": "ATIVO"
			},
			{
				"id": 7,
				"nome": "Nome Exemplo 7",
				"email": "email4@exemplo.com",
				"perfil": [
					{ "nome": "Pefil 1", "status": "C"},
					{"nome": "Pefil 10", "status": "C"},
				],
				"status": "ATIVO"
			},
        ], 
        $scope.searchKeywords = "", 
        $scope.filteredStores = [], 
        $scope.row = "", 
        $scope.select = function(page) {
            var end, start;
            return start = (page - 1) * $scope.numPerPage, end = start + $scope.numPerPage, $scope.currentPageStores = $scope.filteredStores.slice(start, end)
        }, $scope.onFilterChange = function() {
            return $scope.select(1), $scope.currentPage = 1, $scope.row = ""
        }, $scope.onNumPerPageChange = function() {
            return $scope.select(1), $scope.currentPage = 1
        }, $scope.onOrderChange = function() {
            return $scope.select(1), $scope.currentPage = 1
        }, $scope.search = function() {
            return $scope.filteredStores = $filter("filter")($scope.stores, $scope.searchKeywords), $scope.onFilterChange()
        }, $scope.order = function(rowName) {
            return $scope.row !== rowName ? ($scope.row = rowName, $scope.filteredStores = $filter("orderBy")($scope.stores, rowName), $scope.onOrderChange()) : void 0
        }, $scope.numPerPageOpt = [3, 5, 10, 20], $scope.numPerPage = $scope.numPerPageOpt[2], $scope.currentPage = 1, $scope.currentPageStores = [], (init = function() {
            return $scope.search(), $scope.select($scope.currentPage)
        })()


	}])

}())