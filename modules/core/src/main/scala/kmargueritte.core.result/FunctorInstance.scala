package kmargueritte.core.result

import cats.Functor

object functorInstance extends ResultFunctor

trait ResultFunctor {

  implicit def resultFunctor[A, ?]: Functor[Result[A, ?]] = ???

}

