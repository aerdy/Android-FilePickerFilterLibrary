# Android - FilePickerFilter Library

<p align="center">
  <img src="https://aeroyid.files.wordpress.com/2017/03/photo_2017-03-01_19-55-38.jpg" width="350"/>
</p>

```
repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
}
```
```
dependencies {
    compile 'com.github.aerdy:Android-FilePickerFilterLibrary:-SNAPSHOT'
}

```
### Support Android Version
```
minSdkVersion 15
```

```
Intent intent = new Intent(getApplicationContext(),FilePickerActivity.class);
startActivityForResult(intent, idresult);
```
```
 @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String path = data.getStringExtra("path");
                txtPath.setText(path);
                Log.e("data",path);
            }else{
                Log.e("data","cance");
            }
        }
    }
```
# Screenshot

<p align="center">
  <img src="https://aeroyid.files.wordpress.com/2017/03/photo_2017-03-01_19-55-38.jpg" width="200"/>
</p>
<p align="center">
  <img src="https://aeroyid.files.wordpress.com/2017/03/photo_2017-03-01_19-55-55.jpg" width="200"/>
</p>
<p align="center">
  <img src="https://aeroyid.files.wordpress.com/2017/03/photo_2017-03-01_19-55-46.jpg" width="200"/>
</p>

##License
```
Copyright 2020 Necis Studio

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
