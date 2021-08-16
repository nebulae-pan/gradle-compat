# VariantScope
3.6.4
intermediatesDir : variantScope.globalScope.intermediatesDir
fullVariantName : variantScope.fullVariantName

4.1.3
variantScope
```
project.plugins.getPlugin(AppPlugin::class.java).variantManager
    .mainComponents.forEach {
        it.properties.computeTaskName()
    }

```

# task
task createAction

variantManager.getMainComponents()