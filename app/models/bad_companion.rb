class BadCompanion < Green
  has_many :bad_companionships, as: :companion, inverse_of: :companion, class_name: 'Companionship'
  has_many :greens, through: :bad_companionships
end
