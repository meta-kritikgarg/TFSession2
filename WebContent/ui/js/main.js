var app = angular.module('MyApp',['ngRoute']);

app.config(function($routeProvider) {

$routeProvider
.when("/",{
    templateUrl : "template/main.htm",
    controller : "loadCars"
})

.when("/detail:id",{
    templateUrl : "template/detail.htm",
    controller : "loadCarsbyId"
})


.when("/delete:id",{
    templateUrl :"template/main.htm",
    controller : "loadCars"
})

.when("/add",{
    templateUrl : "template/detail.htm",
    controller : "loadCarsbyId"
})

});

app.controller("loadCars",function($scope,$http,$routeParams) {
  $http.get("http://localhost:8080/TFSession01/api/v1/get/carlist/")
    .then(function(response) {
        console.log(response.data);
        $scope.cars = response.data.data;
    });
    if(angular.isDefined($routeParams.id)) {
      $http.delete("http://localhost:8080/TFSession01/api/v1/delete/carlist/"+$routeParams.id)
        .then(function(response1) {
            console.log(response1.data+"deleted");
            //$scope.cars = response.data.data;
            $scope.message = "Deleted Successful"
        });
    }
})


app.controller("loadCarsbyId",function($scope,$http,$routeParams) {
  if(angular.isDefined($routeParams.id)) {
  $http.get("http://localhost:8080/TFSession01/api/v1/get/carlist/"+$routeParams.id)
    .then(function(response) {
        $scope.mycar = response.data.data[0];
    });
  }
    $scope.updateData = function() {
      if(angular.isDefined($routeParams.id)) {
        $http.put("http://localhost:8080/TFSession01/api/v1/put/carlist/"+$routeParams.id, $scope.mycar).then(
          function(data){
            $scope.responsemessage = "Update Successful";
          });
        } else {
          $http.post("http://localhost:8080/TFSession01/api/v1/post/carlist/", $scope.mycar).then(
            function(data){
              $scope.responsemessage = "Added Successful";
            });
        }


    }
})
