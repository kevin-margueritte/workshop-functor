package kmargueritte.core.database

import cats.effect.IO
import kmargueritte.core.model.City

object CoordinateDAO extends FakeDatabase {

  def getCityByCoordinate(lat: BigDecimal, lon: BigDecimal): IO[Option[City]] = {
    IO.pure {
      cityDb.find { case City(_, c) =>
        if (c.lat == lat && c.lon == lon) true else false
      }.headOption
    }
  }

}
