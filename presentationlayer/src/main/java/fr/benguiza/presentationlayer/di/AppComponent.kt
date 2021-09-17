package fr.benguiza.presentationlayer.di

interface AppComponent {
    fun fragmentsComponent(): FragmentsComponent
    fun activitiesComponent(): ActivitiesComponent
}