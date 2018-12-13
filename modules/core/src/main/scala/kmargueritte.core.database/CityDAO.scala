package kmargueritte.core.database

import cats.effect.IO
import kmargueritte.core.model.City

object CityDAO extends FakeDatabase {

  def getAll(): IO[List[City]] =
    IO.pure(cityDb)

  def getCityByName(city: String): IO[Option[City]] =
    IO.pure(cityDb.find(_.name == city).headOption)

}
