package kmargueritte.core.result

sealed trait Result[A, B] {

  import kmargueritte.core.result.functorInstance._

  val error = Result.ErrorProjection(this)
  val ok = Result.OkProjection(this)

  val isOk: Boolean
  val isError: Boolean = !isOk

  def fold[C](fa: A => C, fb: B => C): C = ???

  def map[C](f: B => C): Result[A, C] =
    ???
}

case class Ok[A, B](value: B) extends Result[A, B] {
  override val isOk: Boolean = ???
}

case class Error[A, B](value: A) extends Result[A, B] {
  override val isOk: Boolean = ???
}


object Result {

  def cond[A, B](test: Boolean, ok: => B, error: => A): Result[A, B] = ???

  final case class ErrorProjection[A, B](result: Result[A, B]) {

    def get: A = {
      result match {
        case Error(e) => e
        case _ => throw new NoSuchElementException("Result.ok on Error")
      }
    }
  }

  final case class OkProjection[A, B](result: Result[A, B]) {

    def get: B = {
      result match {
        case Ok(result) => result
        case _ => throw new NoSuchElementException("Result.Error on Ok")
      }
    }

  }

}