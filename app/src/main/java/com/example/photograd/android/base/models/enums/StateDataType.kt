package photograd.kz.photograd.models.enums


enum class StateDataType(val value: String)
{
     user ("user"),
     games ("games"),
     friends ("friends"),
     missions ("missions"),
     active_mission_attempt ("active_mission_attempt"),
     statistics ("statistics"),
     category_statistics ("category_statistics"),
     categories ("categories"),
     achievements ("achievements"),
     top_rating ("top_rating")
}
