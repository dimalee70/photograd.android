package photograd.kz.photograd.models.enums

import com.example.photograd.android.R

enum class ErrorResourceTypeDescription(
    val titleId: Int,
    val messageId: Int) {
    user_not_exist (R.string.title_user_not_exist, R.string.message_user_not_exist),
    incorrect_password_or_email (R.string.title_incorrect_password_or_email, R.string.message_incorrect_password_or_email),
    session_not_exist (R.string.title_session_not_exist, R.string.message_session_not_exist),
    active_mission_exists (R.string.title_active_mission_exists, R.string.message_active_mission_exists),
    mission_not_exist (R.string.title_mission_not_exist, R.string.message_mission_not_exist),
    no_active_mission (R.string.title_no_active_mission_attempt, R.string.message_no_active_mission_attempt),
    game_not_exist (R.string.title_game_not_exist, R.string.message_game_not_exist),
    user_not_challenged (R.string.title_user_not_challenged, R.string.message_user_not_challenged),
    not_challenging_game (R.string.title_not_challenging_game, R.string.message_not_challenging_game),
    gameround_not_exist (R.string.title_gameround_not_exist, R.string.message_gameround_not_exist),
    category_not_exist (R.string.title_category_not_exist, R.string.message_category_not_exist),
    user_not_starting_round (R.string.title_user_not_starting_round, R.string.message_user_not_starting_round),
    gameround_already_finished (R.string.title_gameround_already_finished, R.string.message_gameround_already_finished),
    question_instance_not_exist (R.string.title_question_instance_not_exist, R.string.message_question_instance_not_exist),
    answer_option_not_exist (R.string.title_answer_option_not_exist, R.string.message_answer_option_not_exist),
    category_already_selected (R.string.title_category_already_selected, R.string.message_category_already_selected),
    user_already_in_friendlist (R.string.title_user_already_in_friendlist, R.string.message_user_already_in_friendlist),
    mission_attempt_not_active (R.string.title_mission_attempt_not_active, R.string.message_mission_attempt_not_active),
    mission_attempt_games_amount_exceeded (R.string.title_mission_attempt_games_amount_exceeded, R.string.message_mission_attempt_games_amount_exceeded),
    offer_not_exist (R.string.title_offer_not_exist, R.string.message_offer_not_exist),
    not_enough_apples (R.string.title_not_enough_apples, R.string.message_not_enough_apples),
    user_not_playing_game (R.string.title_user_not_playing_game, R.string.message_user_not_playing_game),
    game_already_finished (R.string.title_game_already_finished, R.string.message_game_already_finished),
    user_already_exists (R.string.title_user_already_exists, R.string.message_user_already_exists),
    friendship_request_already_sent (R.string.title_friendship_request_already_sent, R.string.message_friendship_request_already_sent),
    no_such_friendship_request (R.string.title_no_such_friendship_request, R.string.message_no_such_friendship_request),
    accepting_not_friendship_request (R.string.title_accepting_not_friendship_request, R.string.message_accepting_not_friendship_request),
    declining_not_friendship_request (R.string.title_declining_not_friendship_request, R.string.message_declining_not_friendship_request),
    image_file_error (R.string.title_image_file_error, R.string.message_image_file_error),
    user_not_logged_in (R.string.title_user_not_logged_in, R.string.message_user_not_logged_in),
    partner_mission_not_exist (R.string.title_partner_mission_not_exist, R.string.message_partner_mission_not_exist),
    partner_mission_is_not_active (R.string.title_partner_mission_is_not_active, R.string.message_partner_mission_is_not_active),
    already_playing_partner_mission (R.string.title_already_playing_partner_mission, R.string.message_already_playing_partner_mission),
    purchase_not_exist (R.string.title_purchase_not_exist, R.string.message_purchase_not_exist),
    not_user_purchase (R.string.title_not_user_purchase, R.string.message_not_user_purchase),
    empty_username (R.string.title_empty_username, R.string.message_empty_username),
    incorrect_social_network (R.string.title_incorrect_social_network, R.string.message_incorrect_social_network),
    empty_email (R.string.title_empty_email, R.string.message_empty_email),
    invalid_email (R.string.title_invalid_email, R.string.message_invalid_email),
    should_be_another_user (R.string.title_should_be_another_user, R.string.message_should_be_another_user),
    not_valid_game_type (R.string.title_not_valid_game_type, R.string.message_not_valid_game_type),
    username_max_length_exceeded (R.string.title_username_max_length_exceeded, R.string.message_username_max_length_exceeded),
    purchase_expired (R.string.title_purchase_expired, R.string.message_purchase_expired),
    purchase_already_activated (R.string.title_purchase_already_activated, R.string.message_purchase_already_activated),
    mission_reward_expired (R.string.title_mission_reward_expired, R.string.message_mission_reward_expired),
    mission_reward_already_activated (R.string.title_mission_reward_already_activated, R.string.message_mission_reward_already_activated),
    user_not_confirmed (R.string.title_user_not_confirmed, R.string.message_user_not_confirmed),
    opponent_not_enough_apples (R.string.title_opponent_not_enough_apples, R.string.message_opponent_not_enough_apples),
    incompatible_api_version (R.string.title_incompatible_api_version, R.string.message_incompatible_api_version),
    user_is_blocked (R.string.title_user_is_blocked, R.string.message_user_is_blocked),
    email_already_registered (R.string.title_email_already_registered, R.string.message_email_already_registered),
    question_text_too_short (R.string.title_question_text_too_short, R.string.message_question_text_too_short),
    wrong_number_of_answers (R.string.title_wrong_number_of_answers, R.string.message_wrong_number_of_answers),
    invalid_gender (R.string.title_invalid_gender, R.string.message_invalid_gender),
    wrong_date_format (R.string.title_wrong_date_format, R.string.message_wrong_date_format),
    need_to_play_mission (R.string.title_need_to_play_mission, R.string.message_need_to_play_mission),
    opponent_can_not_play (R.string.title_opponent_can_not_play, R.string.message_opponent_can_not_play),
    no_offers_left (R.string.title_no_offers_left, R.string.message_no_offers_left),
    personal_info_not_set (R.string.title_personal_info_not_set, R.string.message_personal_info_not_set),
    offer_user_purchases_out_of_limit (R.string.title_offer_user_purchases_out_of_limit, R.string.message_offer_user_purchases_out_of_limit),
    offer_user_purchases_out_of_period_limit (R.string.title_offer_user_purchases_out_of_period_limit, R.string.message_offer_user_purchases_out_of_period_limit),
    no_email_in_profile (R.string.title_no_email_in_profile, R.string.message_no_email_in_profile),
    mission_reward_not_exist (R.string.title_mission_reward_not_exist, R.string.message_mission_reward_not_exist),
    not_user_reward (R.string.title_not_user_reward, R.string.message_not_user_reward),
    wrong_activation_key (R.string.title_wrong_activation_key, R.string.message_wrong_activation_key),
    partner_mission_not_available_at_night_time (R.string.title_partner_mission_not_available_at_night_time, R.string.message_partner_mission_not_available_at_night_time),
    not_enough_energy (R.string.title_not_enough_energy, R.string.message_not_enough_energy),
    opponent_not_enough_energy (R.string.title_opponent_not_enough_energy, R.string.message_opponent_not_enough_energy),
    partner_mission_games_limit_exceeded (R.string.title_partner_mission_games_limit_exceeded, R.string.message_partner_mission_games_limit_exceeded)
}