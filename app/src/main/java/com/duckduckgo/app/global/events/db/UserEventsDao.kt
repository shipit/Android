/*
 * Copyright (c) 2020 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.global.events.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserEventsDao {

    @Query("select * from user_events where id=:userEventKey")
    suspend fun getUserEvent(userEventKey: UserEventKey): UserEventEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEventEntity: UserEventEntity)

    @Query("delete from user_events where id=:userEventKey")
    fun delete(userEventKey: UserEventKey)

    @Query("select * from user_events")
    fun userEvents(): Flow<List<UserEventEntity>>
}
