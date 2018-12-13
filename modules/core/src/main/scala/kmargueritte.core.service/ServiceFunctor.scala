package kmargueritte.core.service

import cats.effect.IO
import kmargueritte.core.http.client.Client
import kmargueritte.core.model.{Restaurant, Weather}
import kmargueritte.core.result.Result

class ServiceFunctor {

  def getWeatherByCitiesSync(cities: String*): Seq[Result[String, Weather]]=
    Client.getWeatherByCitiesSync(cities: _*).toList

  def getRestaurantAsync(city: String): IO[Result[String, List[Restaurant]]] =
    Client.getRestaurantAsync(city)

}
