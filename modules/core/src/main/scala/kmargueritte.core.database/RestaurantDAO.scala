package kmargueritte.core.database

import cats.effect.IO
import kmargueritte.core.model.{City, Coordinates, Restaurant}

object RestaurantDAO {

  private val db =
    Restaurant("3B", City("Montpellier", Coordinates(46.36668, 3.522225))) ::
    Restaurant("Burger King", City("Montpellier", Coordinates(46.36668, 3.522225))) ::
    Nil

  def getByCityNameAsync(name: String): IO[Seq[Restaurant]] =
    IO.pure(db.filter(_.city.name == name))

  def getByCityNameSync(name: String): Seq[Restaurant] =
    db.filter(_.city.name == name)

}
