# modular-app-core
Core implementations for a modular Android App
This repo contains core implementations for a __Modular Android App__

Inspired from [n26 Engineering](https://medium.com/@N26)<br>
Special thanks to [Mustafa Berkay Mutlu](https://github.com/mustafaberkaymutlu)


## Modularization:
This repository is created to publish core implementations for a __Modular Android App__

```
- core
- core_presentation
- core_domain
- core_data
```

__Core module__ contains classes which can be used in every layer such as injection annotations, injection scopes, error factories,
data holder models. _Core presentation,_ includes core module and classes which can be used in other features presentation modules
such as base ui classes, generic RecyclerView Adapter, ViewModel factories etc. __Core data__ inclues core module and domain spesific
interfaces such as Interactors. Core Data also includes core module, data source interfaces, default request interceptors and 
api module.

## Tech Stack
- Modularization
- Kotlin
- Clean Architecture
- MVVM
- Kotlin Coroutines
- Dagger2
- Retrofit2
- Architecture Components
- Lifecycle Aware Components
- Repository Pattern
- Android Jetpack
- Kotlin DSL

