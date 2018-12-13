package kmargueritte.step.one.exercice

import cats.effect.IO

import kmargueritte.core.model.City
import kmargueritte.core.result._
import kmargueritte.core.service.ServiceFunctor

object Process extends App {
  import io.circe.syntax._
  import WeatherEncoder._

  val service = new ServiceFunctor

  /**
    * L'objectif est de retourner dans une liste un `Result` contenant `UnfoldUmbrella` s'il pleut sinon retourner `TakeFoldUmbrella`
    *
    * Règles :
    *   - utiliser la méthode `getWeatherByCitiesSync` du service
    *   - utiliser la méthode `compose` de l'instance `Functor` pour composer votre résultat
    *
    * Tips :
    *   - Seq n'est pas un functor
    *   - Les différentes météos sont dans l'énumération `Behaviour`
    *   - La méthode compose est en conflit avec les méthodes Scala, il serait peut-être logique d'instancier la type class `Functor` ??
    */
  def citiesNeedUmbrellaToday(cities: String*): Seq[Result[String, NeedUmbrella]] = ???

  /**
    * L'objectif est de retourner la liste des noms des restaurants présents dans une ville
    *
    * Règles :
    *   - utiliser la méthode `getRestaurantAsync` du service
    *   - utiliser la méthode `compose` de l'instance `Functor` pour composer votre résultat
    *
    * Tips :
    *   - Hop !! hop !! on en enchaine encore les functors ensemble
    *   - myIO.map(_.map(_.map(_.name))) c'est pas jolie !
    *
    */
  def getRestaurantNameInTheCity(city: String): IO[Result[String, List[String]]] = ???

  println("-- City need umbrella --")
  println(citiesNeedUmbrellaToday("Paris", "Barcelone", "Montpellier"))
  println(citiesNeedUmbrellaToday("Paris", "Barcelone", "Montpellier").map(_.fold(_.asJson, _.asJson)))
  println("  ")
  println("-- Restaurants in the city --")
  println(getRestaurantNameInTheCity("Paris").unsafeRunSync())
  println(getRestaurantNameInTheCity("Barcelone").unsafeRunSync())
}

sealed trait NeedUmbrella {
  val city: City
}

case class UnfoldUmbrella(city: City) extends NeedUmbrella
case class TakeFoldUmbrella(city: City) extends NeedUmbrella
