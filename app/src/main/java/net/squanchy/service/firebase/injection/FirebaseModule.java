package net.squanchy.service.firebase.injection;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.squanchy.injection.ApplicationLifecycle;
import net.squanchy.service.firebase.AuthenticatedFirebaseDbService;
import net.squanchy.service.firebase.FirebaseAuthService;
import net.squanchy.service.firebase.FirebaseDbService;
import net.squanchy.service.firebase.UnauthenticatedFirebaseDbService;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    @Provides
    DatabaseReference databaseReference() {
        return FirebaseDatabase.getInstance().getReference();
    }

    @Provides
    FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance();
    }

    @Provides
    FirebaseAuthService firebaseAuthService(FirebaseAuth firebaseAuth) {
        return new FirebaseAuthService(firebaseAuth);
    }

    @ApplicationLifecycle
    @Provides
    @DbServiceType(DbServiceType.Type.AUTHENTICATED)
    FirebaseDbService authenticatedDbService(
            @DbServiceType(DbServiceType.Type.UNAUTHENTICATED) FirebaseDbService dbService,
            FirebaseAuthService authService
    ) {
        return new AuthenticatedFirebaseDbService(dbService, authService);
    }

    @ApplicationLifecycle
    @Provides
    @DbServiceType(DbServiceType.Type.UNAUTHENTICATED)
    FirebaseDbService unauthenticatedDbService(DatabaseReference database) {
        return new UnauthenticatedFirebaseDbService(database);
    }
}
