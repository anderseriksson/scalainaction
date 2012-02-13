/*
 * Copyright 2011-2012 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package name.heikoseeberger.akkaexamples.nonblocking

import akka.actor.{ Actor, ActorRef }

object TranslationActor {
  case class TranslateText(text: String)
}

class TranslationActor extends Actor {
  import TranslationActor._

  override protected def receive = {
    case TranslateText(text) =>
      Thread.sleep(100)
      sender ! ResponderActor.TranslatedText(text.reverse)
      context.stop(self)
  }
}
