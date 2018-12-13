package kmargueritte.core.database

import kmargueritte.core.model.{City, Coordinates}

trait FakeDatabase {

  val cityDb = City("Montpellier", Coordinates(46.36668, 3.522225)) ::
      City("Paris", Coordinates(48.866667, 2.333333)) ::
      City("Toulouse", Coordinates(43.6, 1.433333)) ::
      Nil

}
