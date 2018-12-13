package kmargueritte.step.one.exercice

import cats.Functor
import kmargueritte.core.result._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class FunctorResultSpec extends FlatSpec with Matchers with PropertyChecks {
  import kmargueritte.core.result.functorInstance._

  "Result instance functor" should
    "respect identity law" in {

      forAll { (a:Int) =>
        val ok: Result[Int, Int] = Ok(a)
        val error: Result[Int, Int] = Error(a)

        Functor[Result[Int, ?]].map(ok)(identity) shouldBe(ok)
        Functor[Result[Int, ?]].map(error)(identity) shouldBe(error)
      }

    }

    it must "respect composition law" in {
      forAll { (a: Int, b:Int, c: Int) =>
        val ok: Result[Int, Int] = Ok(a)
        val error: Result[Int, Int] = Error(a)

        val f: (Int => Int) = (y: Int) => y + b
        val g: (Int => Int) = (y: Int) => y + c

        val okMapF = Functor[Result[Int, ?]].map(ok)(f)
        val okMapFMapG = Functor[Result[Int, ?]].map(okMapF)(g)
        val okMapFAndThenG = Functor[Result[Int, ?]].map(ok)(f.andThen(g))

        okMapFAndThenG shouldBe(okMapFMapG)


        val errorMapF = Functor[Result[Int, ?]].map(error)(f)
        val errorMapFMapG = Functor[Result[Int, ?]].map(errorMapF)(g)
        val errorMapFAndThenG = Functor[Result[Int, ?]].map(error)(f.andThen(g))

        errorMapFAndThenG shouldBe(errorMapFMapG)
      }
    }

}
