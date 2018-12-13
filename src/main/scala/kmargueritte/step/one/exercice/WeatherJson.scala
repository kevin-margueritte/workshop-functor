package kmargueritte.step.one.exercice

trait WeatherJson {
  import io.circe.Encoder

  implicit val needUmbrellaEncoder: Encoder[NeedUmbrella] = ???
}

object WeatherEncoder extends WeatherJson

