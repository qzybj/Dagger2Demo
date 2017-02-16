/*
 * Copyright (C) 2013 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.brady.dagger2demo.ui;

import com.brady.dagger2demo.AbstractActivityComponent;
import com.brady.dagger2demo.ActivityModule;
import com.brady.dagger2demo.ApplicationComponent;
import com.brady.dagger2demo.module.annotation.PerActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface HomeComponent extends AbstractActivityComponent {
  void inject(HomeActivity homeActivity);
  void inject(HomeFragment homeFragment);
}
