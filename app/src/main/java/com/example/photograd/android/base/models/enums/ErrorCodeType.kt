package photograd.kz.photograd.models.enums

enum class ErrorCodeType(val value: String)
{
    user_not_exist ( "user_not_exist"),
    incorrect_password_or_email ( "incorrect_password_or_email"),
    session_not_exist ( "session_not_exist"),
    active_mission_exists ( "active_mission_exists"),
    mission_not_exist ( "mission_not_exist"),
    no_active_mission ( "no_active_mission"),
    game_not_exist ( "game_not_exist"),
    user_not_challenged ( "user_not_challenged"),
    not_challenging_game ( "not_challenging_game"),
    gameround_not_exist ( "gameround_not_exist"),
    category_not_exist ( "category_not_exist"),
    user_not_starting_round ( "user_not_starting_round"),
    gameround_already_finished ( "gameround_already_finished"),
    question_instance_not_exist ( "question_instance_not_exist"),
    answer_option_not_exist ( "answer_option_not_exist"),
    category_already_selected ( "category_already_selected"),
    offer_not_exist ( "offer_not_exist"),
    not_enough_apples ( "not_enough_apples"),
    user_not_playing_game ( "user_not_playing_game"),
    game_already_finished ( "game_already_finished"),
    user_already_exists ( "user_already_exists"),
    user_already_in_friendlist ( "user_already_in_friendlist"),
    image_file_error ( "image_file_error"),
    friendship_request_already_sent ( "friendship_request_already_sent"),
    no_such_friendship_request ( "no_such_friendship_request"),
    accepting_not_friendship_request ( "accepting_not_friendship_request"),
    declining_not_friendship_request ( "declining_not_friendship_request"),
    partner_mission_not_exist ( "partner_mission_not_exist"),
    partner_mission_is_not_active ( "partner_mission_is_not_active"),
    already_playing_partner_mission ( "already_playing_partner_mission"),
    purchase_not_exist ( "purchase_not_exist"),
    not_user_purchase ( "not_user_purchase"),
    no_active_mission_attempt ( "no_active_mission_attempt"),
    user_not_logged_in ( "user_not_logged_in"),
    empty_username ( "empty_username"),
    empty_email  ( "empty_email"),
    invalid_email  ( "invalid_email"),
    incorrect_social_network ( "incorrect_social_network"),
    no_offers_left ( "no_offers_left"),
    should_be_another_user ( "should_be_another_user"),
    not_valid_game_type ( "not_valid_game_type"),
    mission_attempt_not_active ( "mission_attempt_not_active"),
    mission_attempt_games_amount_exceeded ( "mission_attempt_games_amount_exceeded"),
    no_email_in_profile  ( "no_email_in_profile"),
    username_max_length_exceeded  ( "username_max_length_exceeded"),
    mission_reward_expired  ( "mission_reward_expired"),
    mission_reward_already_activated  ( "mission_reward_already_activated"),
    mission_reward_not_exist  ( "mission_reward_not_exist"),
    mission_reward_already_confirmed  ( "mission_reward_already_confirmed"),
    purchase_expired  ( "purchase_expired"),
    purchase_already_activated  ( "purchase_already_activated"),
    user_not_confirmed  ( "user_not_confirmed"),
    opponent_not_enough_apples  ( "opponent_not_enough_apples"),
    not_user_reward  ( "not_user_reward"),
    incompatible_api_version  ( "incompatible_api_version"),
    wrong_activation_key  ( "wrong_activation_key")
}