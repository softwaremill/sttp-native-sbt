import cats.effect.{IO, IOApp}
import sttp.client4.*
import sttp.client4.curl.*
import sttp.client4.Response

object Sttp4NativeCe3 extends IOApp.Simple:
  val backend = CurlBackend()
  val sendRequest: IO[Response[String]] =
    IO.blocking(
      quickRequest
        .get(uri"http://icanhazip.com")
        .send(backend)
    )

  val run = IO.println("Sending...") >>
    sendRequest.flatMap(response => IO.println(response.body))
