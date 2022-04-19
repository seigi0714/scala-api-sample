package di

import com.google.inject.AbstractModule
import domain.repositories.UserRepository

// Guiceモジュール
class InfraModule extends AbstractModule {
  override def configure(): Unit = {
    // 使う実装を接続する
    // infraパッケージ内で実装したクラスを注入
    bind(classOf[UserRepository]).to(classOf[infra.UserRepository])
  }
}